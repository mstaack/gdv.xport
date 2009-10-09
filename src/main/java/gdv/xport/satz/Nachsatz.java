/*
 * $Id$
 *
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
 * (c)reated 05.10.2009 by Oli B. (oliver.boehm@agentes.de)
 */

package gdv.xport.satz;

import gdv.xport.feld.NumFeld;


/**
 * @author oliver
 * @since 05.10.2009
 * @version $Revision$
 * 
 */
public final class Nachsatz extends Satz {
	
	private final NumFeld anzahlSaetze = new NumFeld("00000", 5);

	public Nachsatz() {
		super("9999");
		this.createTeildatensaetze(1);
		this.setAnzahlSaetze(0);
	}

	public void setAnzahlSaetze(int n) {
		this.anzahlSaetze.setInhalt(n);
		this.teildatensatz[0].setData(anzahlSaetze);
	}

}
