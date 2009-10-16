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
 * (c)reated 13.10.2009 by Oli B. (oliver.boehm@agentes.de)
 */

package gdv.xport.satz;

import java.io.IOException;

import org.junit.Test;

/**
 * @author oliver
 * @since 13.10.2009
 * @version $Revision$
 */
public class AdressteilTest extends AbstractSatzTest {
	
	private Adressteil adressteil = new Adressteil();

	/**
	 * Test method for {@link gdv.xport.satz.Adressteil#Adressteil()}.
	 * @throws IOException 
	 */
	@Test
	public void testAdressteil() throws IOException {
		checkExport(adressteil, 256, 256, "1", 1280);
		checkExport(adressteil, 512, 512, "2", 1280);
	}

}
