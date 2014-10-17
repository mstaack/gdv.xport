/*
 * Copyright (c) 2014 by Oli B.
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
 * (c)reated 07.08.2014 by Oli B. (ob@aosd.de)
 */

package gdv.xport.satz.xml;

import gdv.xport.feld.Bezeichner;
import gdv.xport.util.XmlHelper;

import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Diese Klasse repraesentiert die Wert, die als "<feldreferenz>" ueber XML
 * reinkommen.
 *
 * @author oliver (oliver.boehm@gmail.com)
 * @since 1.0 (07.08.2014)
 */
public final class FeldReferenz {

    private static final Logger LOG = LoggerFactory.getLogger(FeldReferenz.class);

    private final String id;
    private final Bezeichner bezeichner;
    private final String auspraegung;

    /**
     * Instantiiert eine Objekt mit den Werten, die ueber den uebergebenen
     * Parser gelesen werden.
     *
     * @param parser the parser
     * @throws XMLStreamException the XML stream exception
     */
    public FeldReferenz(final XMLEventReader parser) throws XMLStreamException {
        this(parser, XmlHelper.getNextStartElement(parser));
    }

    /**
     * Instantiiert eine Objekt mit den Werten, die ueber den uebergebenen
     * Parser gelesen werden.
     *
     * @param parser the parser
     * @param element das Start-Element <feldreferenz referenz=... >
     * @throws XMLStreamException the XML stream exception
     */
    public FeldReferenz(final XMLEventReader parser, final StartElement element) throws XMLStreamException {
        id = element.getAttributeByName(new QName("referenz")).getValue();
        Properties props = XmlHelper.parseSimpleElements(element.getName(), parser);
        this.bezeichner = new Bezeichner(props);
        this.auspraegung = props.getProperty("auspraegung", "");
        LOG.debug("{} created.", this);
    }

    /**
     * Liefert die Referenz (Id).
     *
     * @return z.B. "BN-2003.02.11.22.49.47.214"
     */
    public String getId() {
        return this.id;
    }

    /**
     * Liefert den Bezeichner mit Name und technischen Namen.
     *
     * @return den Bezeichner
     */
    public Bezeichner getBezeichner() {
        return this.bezeichner;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.bezeichner.getName();
    }

    /**
     * Gets the technischer name.
     *
     * @return the technischer name
     */
    public String getTechnischerName() {
        return this.bezeichner.getTechnischerName();
    }

    /**
     * Gets the auspraegung.
     *
     * @return the auspraegung
     */
    public String getAuspraegung() {
        return this.auspraegung;
    }

    /**
     * Dient zum Ermitteln, ob uerhaupt das auspraegung-Feld belegt ist.
     *
     * @return true falls auspraeung > 0
     */
    public boolean hasAuspraegung() {
        return StringUtils.isNotEmpty(this.auspraegung);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " \"" + this.id + "\" (" + this.bezeichner + ")";
    }

}
