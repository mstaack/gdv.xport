/*
 * Copyright (c) 2010 by agentes
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
 * (c)reated 08.03.2011 by Oli B. (oliver.boehm@agentes.de)
 */

package gdv.xport.satz.sop;

import static org.junit.Assert.*;
import gdv.xport.feld.Bezeichner;

import org.junit.Test;

/**
 * JUnit-Test fuer FeldAllgemeinerVertragsteil.
 * 
 * @author oliver (oliver.boehm@agentes.de)
 * @since 0.6 (08.03.2011)
 */
public final class FeldAllgemeinerVertragsteilTest {

    /**
     * Test method for {@link FeldAllgemeinerVertragsteil#getAsBezeichner()}.
     */
    @Test
    public void testGetAsBezeichner() {
        assertEquals(Bezeichner.INKASSOART, FeldAllgemeinerVertragsteil.INKASSOART.getAsBezeichner());
    }

}
