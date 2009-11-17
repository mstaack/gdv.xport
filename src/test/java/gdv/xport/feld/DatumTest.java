/*
 * Copyright (c) 2009 by agentes
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
 * (c)reated 24.10.2009 by Oli B. (oliver.boehm@agentes.de)
 */

package gdv.xport.feld;

import static org.junit.Assert.*;

import java.util.*;

import net.sf.oval.ConstraintViolation;

import org.apache.commons.logging.*;
import org.junit.Test;

/**
 * @author oliver
 * @since 24.10.2009
 * @version $Revision$
 *
 */
public class DatumTest {

    private static final Log log = LogFactory.getLog(DatumTest.class);

    /**
     * Test method for {@link gdv.xport.feld.Datum#setInhalt(java.util.Date)}.
     */
    @Test
    public void testSetInhaltDate() {
        Date today = Datum.heute().toDate();
        Datum datum = new Datum();
        datum.setInhalt(today);
        assertEquals(today, datum.toDate());
    }

    @Test(expected=IllegalStateException.class)
    public void testToDate() {
        Datum silvester = new Datum("Silvester", "31122009");
        log.info("Silvester is at " + silvester.toDate());
        Datum invalid = new Datum("invalid", "xxxxxxxx");
        log.info("invalid date: " + invalid.toDate());
    }

    @Test
    public void testIsValid() {
        Datum xmas = new Datum("Xmas", "24122009");
        assertTrue(xmas + " should be a valid date", xmas.isValid());
        assertEquals(0, xmas.validate().size());
    }

    @Test
    public void testValidateEmptyDatum() {
        Datum empty = new Datum();
        assertTrue(empty + " should be valid", empty.isValid());
    }

    @Test
    public void testIsInvalid() {
        checkInvalidDatum("xxxxxxxx");
    }

    @Test
    public void testInvalidDatum() {
        checkInvalidDatum("29022009");
    }

    private void checkInvalidDatum(String mmddjjjj) {
        Datum datum = new Datum("Test-Datum", mmddjjjj);
        assertTrue(datum + " is not a valid date!", datum.isInvalid());
        List<ConstraintViolation> violations = datum.validate();
        for (ConstraintViolation violation : violations) {
            log.info(violation);
        }
        assertEquals(1, violations.size());
    }
    
    /**
     * Wenn ein Datum nur aus 6 Zeichen besteht, hat es laut
     * Broschuere Vermittle das Format MMJJJJ.
     * 
     * @since 0.2
     */
    @Test
    public void testDatumMMJJJJ() {
        checkDatum("112009");
    }
    
    @Test
    public void testDatumTT() {
        checkDatum("30");
    }

    /**
     * Bei Datumsangaben ist bei Tag und Monat auch die Eingabe "00" gueltig
     * (au�er im Vorsatz).
     * 
     * @since 0.2
     */
    @Test
    public void testDatum00() {
        checkDatum("00");
        checkDatum("002009");
        checkDatum("00112009");
        checkDatum("00002009");
    }
    
    private static void checkDatum(String inhalt) {
        Datum datum = new Datum("Test-Datum", inhalt);
        assertEquals(inhalt, datum.getInhalt());
        assertTrue(datum + " should be a valid date", datum.isValid());        
    }
    
    @Test
    public void testIsEmpty() {
        Datum empty = new Datum("empty", "00000000");
        assertTrue(empty + " is empty", empty.isEmpty());
    }

}

