/*
 * Copyright (c) 2011, 2012 by aosd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express orimplied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * (c)reated 26.03.2011 by Oli B. (ob@aosd.de)
 */

package gdv.xport.satz.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import gdv.xport.annotation.FelderInfo;
import gdv.xport.satz.Satz;
import gdv.xport.satz.feld.Feld200;
import gdv.xport.satz.feld.MetaFeldInfo;
import gdv.xport.satz.feld.common.Feld1bis7;
import gdv.xport.satz.feld.sparte53.Feld220;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * JUnit test for SatzX.
 *
 * @author oliver (oliver.boehm@agentes.de)
 * @since 26.03.2011
 */
public final class SatzXTest {

    private static Log log = LogFactory.getLog(SatzXTest.class);

    /**
     * Test method for {@link SatzX#SatzX(int, java.lang.Enum[])}.
     */
    @Test
    public void testSatzX() {
        Satz satz200 = new SatzX(200, Feld200.values());
        assertEquals(2, satz200.getTeildatensaetze().size());
    }

    /**
     * Test method for {@link SatzX#getAsList(Enum[])}.
     */
    @Test
    public void testGetAsListSimple() {
        List<Enum<?>> feldInfos = SatzX.getAsList(Feld200.values());
        assertFalse("empty list for feldInfos", feldInfos.isEmpty());
        log.info("Feld200 has " + feldInfos.size() + " FeldInfos.");
        assertTrue("Feld200 should have more than " + Feld200.values().length + " entries",
                feldInfos.size() >= Feld200.values().length);
    }

    /**
     * Test method for {@link SatzX#getAsList(Enum[])}.
     */
    @Test
    public void testGetAsListComposite() {
        List<Enum<?>> feldInfos = SatzX.getAsList(Feld220.values());
        assertFalse("empty list for feldInfos", feldInfos.isEmpty());
        log.info(Feld220.class.getName() + " has " + feldInfos.size() + " FeldInfos.");
        assertTrue("elements are missing", feldInfos.size() > Feld220.values().length);
    }

    /**
     * {@link Feld1bis7} ist ein Beispiel, wo kein Teildatensatz gesetzt ist.
     * Dieser wird z.B. beim {@link Feld200} ueber die {@link FelderInfo}-
     * Annotation gesetzt. Ob dieses Wert tatsaechlich gesetzt wird, wird
     * ueber diesen Test geprueft.
     */
    @Test
    public void testGetAsListTeildatensatz() {
        List<MetaFeldInfo> metaFeldInfos = SatzX.getMetaFeldInfos(Feld200.values());
        int found = 0;
        for (MetaFeldInfo metaFeldInfo : metaFeldInfos) {
            if (metaFeldInfo.getName().equals("SATZART")) {
                found++;
                checkSatzart(metaFeldInfo, found);
            }
        }
    }

    private static void checkSatzart(final MetaFeldInfo satzart, final int found) {
        log.info(found + ". MetaFeldInfo: " + satzart );
        assertEquals(1, satzart.getNr());
        assertEquals(found, satzart.getTeildatensatzNr());
    }

}
