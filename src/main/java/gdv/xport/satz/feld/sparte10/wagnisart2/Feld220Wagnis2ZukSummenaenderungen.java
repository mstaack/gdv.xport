/*
 * Copyright (c) 2011, 2012 by Oli B.
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
 * (c)reated 23.03.2011 by Oli B. (ob@aosd.de)
 */

package gdv.xport.satz.feld.sparte10.wagnisart2;

import gdv.xport.annotation.*;
import gdv.xport.feld.*;
import gdv.xport.satz.feld.common.Feld1bis7;

/**
 * Diese Enum-Klasse repraesentiert die Felder fuer Satzart 220, Sparte 10.<br/>
 * "Leben - Rentenversicherung = Wagnisart 2 - Zukünftige Summenänderungen" (Satzart 0220)
 *
 * @author ralfklemmer
 * @since 19.01.2013
 */
public enum Feld220Wagnis2ZukSummenaenderungen {

    // /// Teildatensatz 1 /////////////////////////////////////////////////

    /** Feld 1 - 7 sind fuer jeden (Teil-)Datensatz identisch. */
    @FelderInfo(
            sparte = 10,
            teildatensatz = 1,
            type = Feld1bis7.class)
    INTRO1,

    /**
     * Laufende Nummer der versicherten Person (VP).<br/>
     * lfd. Nr., die im VU geführt wird
     */
    @FeldInfo(teildatensatz = 1, nr = 8, type = AlphaNumFeld.class, anzahlBytes = 17, byteAdresse = 43)
    LFD_NUMMER_VP_PERSONENGRUPPE,

    /**
     * Wagnisart.<br/>
     * 1 = Kapitallebensversicherung 3 = Risikoversicherung
     */
    @FeldInfo(teildatensatz = 1, nr = 9, type = Zeichen.class, anzahlBytes = 1, byteAdresse = 60)
    WAGNISART,

    /**
     * Lfd Nummer zur Wagnisart.<br/>
     */
    @FeldInfo(teildatensatz = 1, nr = 10, type = Zeichen.class, anzahlBytes = 1, byteAdresse = 61)
    LFD_NUMMER_ZUR_WAGNISART,

    /**
     * Laufende Nummer der Satzart.<br/>
     * Laufende Nummer der Satzart 0220.010.2/6 innerhalb der gleichen Folgenummer<br/>
     * (z. B. n-fache hintereinanderfolgende Lieferung der Satzart 0220.010.2/6, wenn mehrere Bezugsrechte vorhanden)
     */
    @FeldInfo(teildatensatz = 1, nr = 11, type = AlphaNumFeld.class, anzahlBytes = 2, byteAdresse = 62)
    LFD_NUMMER_SATZART,

    /**
     * Anfängliche Todesfall VS in Währungseinheiten.<br/>
     * Anfängliche bzw. erste Todesfalleistung<br/>
     * (9,0 Stellen)
     */
    @FeldInfo(teildatensatz = 1, nr = 12, type = Betrag.class, anzahlBytes = 9, byteAdresse = 64)
    ANFAENGLICHE_TODESFALL_VS_IN_WAEHRUNGSEINHEITEN,

    /**
     * Änderung der Todesfallleistung.<br/>
     * 0 = keine Änderung bzw. nur eine Todesfallleistung<br/>
     * 1 = Erhöhung der Todesfallleistung<br/>
     * 2 = Reduzierung der Todesfallleistung
     */
    @FeldInfo(teildatensatz = 1, nr = 13, type = Zeichen.class, anzahlBytes = 1, byteAdresse = 73)
    AENDERUNG_DER_TODESFALLLEISTUNG,

    /**
     * Abstand der Todesfalländerungstermine.<br/>
     * in Monaten bei periodischen Änderungsterminen <br/>
     * in Monaten bei periodischen Auszahlungen<br/>
     * 000 = keine Änderungen/Auszahlungen<br/>
     * 999 = unregelmäßige Änderungen/Auszahlungen
     */
    @FeldInfo(teildatensatz = 1, nr = 14, type = NumFeld.class, anzahlBytes = 3, byteAdresse = 74)
    ABSTAND_DER_TODESFALLAENDERUNGSTERMINE,

    /**
     * Todesfalländerungs-Prozentsatz.<br/>
     * Konstanter Prozentsatz der Steigerung bzw. Reduzierung der Todesfalleistung<br/>
     * (3,2 Stellen)
     */
    @FeldInfo(teildatensatz = 1, nr = 15, type = NumFeld.class, anzahlBytes = 5, byteAdresse = 77)
    TODESFALLAENDERUNGS_PROZENTSATZ,

    /**
     * Absolute Todesfalländerungssumme in Währungseinheiten.<br/>
     * Absolute Summe der Steigerung bzw. Reduzierung der Todesfalleistung<br/>
     * (9,0 Stellen)
     */
    @FeldInfo(teildatensatz = 1, nr = 16, type = Betrag.class, anzahlBytes = 9, byteAdresse = 82)
    ABSOLUTE_TODESFALLAENDERUNGSSUMME_VS_IN_WAEHRUNGSEINHEITEN,

    /**
     * Nächste Todesfall VS in Währungseinheiten.<br/>
     * Todesfalleistung ab dem nächsten Änderungstermin<br/>
     * (9,0 Stellen)
     */
    @FeldInfo(teildatensatz = 1, nr = 17, type = Betrag.class, anzahlBytes = 9, byteAdresse = 91)
    NAECHSTE_TODESFALL_VS_IN_WAEHRUNGSEINHEITEN,

    /**
     * Beginndatum der nächsten Todesfall VS.<br/>
     * Sollten Tag und/oder Monat nicht vorhanden sein, muss "00" geschlüsselt werden Datum der nächsten
     * Todesfalländerung<br/>
     * Tag/Monat/Jahr (TTMMJJJJ)
     */
    @FeldInfo(teildatensatz = 1, nr = 18, type = Datum.class, anzahlBytes = 8, byteAdresse = 100)
    BEGINNDATUM_DER_NAECHSTEN_TODESFALL_VS,

    /**
     * Anfängliche Jahresrente in Währungseinheiten.<br/>
     * Anfängliche bzw. erste Erlebensfall VS
     */
    @FeldInfo(teildatensatz = 1, nr = 19, type = Betrag.class, anzahlBytes = 12, byteAdresse = 108)
    ANFAENGLICHE_JAHRESRENTE_IN_WAEHRUNGSEINHEITEN,

    /**
     * Änderung der Jahresrente<br/>
     * 0 = keine Änderung bzw. nur eine Erlebensfall VS<br/>
     * 1 = Erhöhung der Erlebensfall VS<br/>
     * 2 = Reduzierung der Erlebensfall VS
     */
    @FeldInfo(teildatensatz = 1, nr = 20, type = Zeichen.class, anzahlBytes = 1, byteAdresse = 120)
    AENDERUNG_DER_JAHRESRENTE,

    /**
     * Abstand der Jahresrentenänderungstermine.<br/>
     * in Monaten bei periodischen Änderungsterminen <br/>
     * in Monaten bei periodischen Auszahlungen<br/>
     * 000 = keine Änderungen/Auszahlungen<br/>
     * 999 = unregelmäßige Änderungen/Auszahlungen
     */
    @FeldInfo(teildatensatz = 1, nr = 21, type = NumFeld.class, anzahlBytes = 3, byteAdresse = 121)
    ABSTAND_DER_JAHRESRENTENAENDERUNGSTERMINE,

    /**
     * Jahresrentenaenderungs-Prozentsatz.<br/>
     * Konstanter Prozentsatz der Steigerung bzw. Reduzierung der Jahresrente<br/>
     * (3,2 Stellen)
     */
    @FeldInfo(teildatensatz = 1, nr = 22, type = NumFeld.class, anzahlBytes = 5, byteAdresse = 124)
    JAHRESRENTENAENDERUNGS_PROZENTSATZ,

    /**
     * Absolute Jahresrentenänderungssumme in Währungseinheiten.<br/>
     * Absolute Summe der Steigerung bzw. Reduzierung der Jahresrente
     */
    @FeldInfo(teildatensatz = 1, nr = 23, type = Betrag.class, anzahlBytes = 12, byteAdresse = 129)
    ABSOLUTE_JAHRESRENTENAENDERUNGSSUMME_IN_WAEHRUNGSEINHEITEN,

    /**
     * Nächste Jahresrente in Währungseinheiten.<br/>
     * Jahresrente ab dem nächsten Änderungstermin
     */
    @FeldInfo(teildatensatz = 1, nr = 24, type = Betrag.class, anzahlBytes = 12, byteAdresse = 141)
    NAECHSTE_JAHRESRENTE_IN_WAEHRUNGSEINHEITEN,

    /**
     * Beginndatum der nächsten Jahresrente.<br/>
     * Sollten Tag und/oder Monat nicht vorhanden sein, muss "00" geschlüsselt werden Datum der nächsten Erlebensfall
     * VS<br/>
     * Tag/Monat/Jahr (TTMMJJJJ)
     */
    @FeldInfo(teildatensatz = 1, nr = 25, type = Datum.class, anzahlBytes = 8, byteAdresse = 153)
    BEGINNDATUM_DER_NAECHSTEN_JAHRESRENTE,

    /**
     * Leerstellen.<br/>
     */
    @FeldInfo(teildatensatz = 1, nr = 26, type = AlphaNumFeld.class, anzahlBytes = 95, byteAdresse = 161)
    LEERSTELLEN
}
