/* Copyright 2004, 2005 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acegisecurity.ldap;

import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.NamingException;

/**
 * A user representation which is used internally by the Ldap provider.
 *
 *
 * @deprecated in favour of {@link org.acegisecurity.userdetails.ldap.LdapUserDetails}
 *
 *
 * @author Luke Taylor
 * @version $Id$
 */
public class LdapUserInfo {

    //~ Instance fields ========================================================

    private String dn;
    private Attributes attributes;

    //~ Constructors ===========================================================

    /**
     *
     * @param dn the full DN of the user
     * @param attributes any attributes loaded from the user's directory entry.
     */
    public LdapUserInfo(String dn, Attributes attributes) {
        this.dn = dn;
        this.attributes = attributes;
    }

    //~ Methods ================================================================

    public String getDn() {
        return dn;
    }

    public String getRelativeName(DirContext ctx) throws NamingException {
        return LdapUtils.getRelativeName(dn, ctx);
    }

    public Attributes getAttributes() {
        return (Attributes)attributes.clone();
    }
}
