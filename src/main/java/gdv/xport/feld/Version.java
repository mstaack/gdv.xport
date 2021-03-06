/*
 * Copyright (c) 2009 - 2012 by Oli B.
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
 * (c)reated 10.10.2009 by Oli B. (ob@aosd.de)
 */

package gdv.xport.feld;

import gdv.xport.annotation.FeldInfo;

/**
 * Versions-Feld.
 *
 * @author oliver
 * @since 10.10.2009
 * @version $Revision$
 */
public class Version extends Feld {

    /**
     * Legt ein neues Versions-Feld an.
     * <p>
     * TODO: bitte nicht mehr verwenden - wird in 1.2 entfernt!
     * </p>
     *
     * @param name Name des Feldes
     * @param start Start-Byte (beginnend bei 1)
     * @deprecated bitte {@link #Version(Bezeichner, int)} benutzen
     */
    @Deprecated
    public Version(final String name, final int start) {
        this(new Bezeichner(name), start);
    }

    /**
     * Legt ein neues Versions-Feld an.
     *
     * @param name Name des Feldes
     * @param start Start-Byte (beginnend bei 1)
     * @since 1.0
     */
    public Version(final Bezeichner name, final int start) {
        super(name, 3, start, Align.LEFT);
    }

    /**
     * Legt ein neues Versions-Feld an. Die Informationen dazu werden
     * aus der uebergebenen Enum bezogen.
     *
     * @param feldX Enum mit den Feldinformationen
     * @since 0.9
     */
    public Version(final Enum<?> feldX) {
        super(feldX);
    }

    /**
     * Instantiiert ein neues Versions-Objekt.
     * <p>
     * TODO: bitte nicht mehr verwenden - wird in 1.2 entfernt!
     * </p>
     *
     * @param name Bezeichner
     * @param info mit der Start-Adresse
     * @since 0.6
     * @deprecated bitte {@link #Version(Enum)} benutzen
     */
    @Deprecated
    public Version(final String name, final FeldInfo info) {
        this(name, info.byteAdresse());
        assert info.anzahlBytes() == 3 : "Version hat nicht das Format x.x";
    }

    /**
     * Instantiiert ein neues Versions-Objekt.
     *
     * @param name Name des Feldes
     * @param start Start-Byte (beginnend bei 1)
     * @param v Versions-String (z.B. "1.1")
     */
    public Version(final String name, final int start, final String v) {
        super(name, 3, start, v, Align.LEFT);
        assert v.length() == 3 : "Version hat nicht das Format x.x";
    }

}

