/***********************************************************************
 * Copyright (c) 2003-2004 The Apache Software Foundation.             *
 * All rights reserved.                                                *
 * ------------------------------------------------------------------- *
 * Licensed under the Apache License, Version 2.0 (the "License"); you *
 * may not use this file except in compliance with the License. You    *
 * may obtain a copy of the License at:                                *
 *                                                                     *
 *     http://www.apache.org/licenses/LICENSE-2.0                      *
 *                                                                     *
 * Unless required by applicable law or agreed to in writing, software *
 * distributed under the License is distributed on an "AS IS" BASIS,   *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or     *
 * implied.  See the License for the specific language governing       *
 * permissions and limitations under the License.                      *
 ***********************************************************************/

package org.apache.jsieve.commands;

import org.apache.jsieve.Arguments;
import org.apache.jsieve.Block;
import org.apache.jsieve.SieveException;
import org.apache.jsieve.mail.MailAdapter;

/**
 * Class Discard implements the Discard Command as defined in RFC 3028, section 4.5.
 */
public class Discard extends AbstractActionCommand
{

    /**
     * Constructor for Discard.
     */
    public Discard()
    {
        super();
    }

    /**
     * <p>Discard silently discards a Mail by cancelling the implicit keep as 
     * specified in RFC 3028, Section 4.5.</p>
     *<p>
     * @see org.apache.jsieve.commands.AbstractCommand#executeBasic(MailAdapter, Arguments, Block)
     * </p>
     */  
    protected Object executeBasic(MailAdapter mail, Arguments arguments, Block block)
        throws SieveException
    {                
//        mail.addAction(new ActionDiscard());
        return null;
    }

}
