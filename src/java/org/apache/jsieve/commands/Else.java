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
import org.apache.jsieve.CommandException;
import org.apache.jsieve.SieveException;
import org.apache.jsieve.mail.MailAdapter;

/**
 * Class Else implements the Else Command as defined in RFC 3028, section 3.1.
 */
public class Else extends AbstractConditionalCommand
{
    
    /**
     * Constructor for Else.
     */
    public Else()
    {
        super();
    }    

    /**
     * <p>Conditionally eexecute a Block if an Else Condition is runnable.</p> 
     * <p>Also,
     * @see org.apache.jsieve.commands.AbstractCommand#executeBasic(MailAdapter, Arguments, Block)
     * </p>
     */
    protected Object executeBasic(
        MailAdapter mail,
        Arguments arguments,
        Block block)
        throws SieveException
    {
        // Check Syntax
        if (!ConditionManager.getInstance().isElseAllowed())
            throw new CommandException("Unexpected Command: \"else\".");

        // Check Runnable                
        if (!ConditionManager.getInstance().isElseRunnable())
            return Boolean.FALSE;

        // Execute the Block 
        execute(mail, block);

        // Update the ConditionManager
        // 'Else' is always true             
        ConditionManager.getInstance().setElseTestResult(true);

        // Return the result
        return Boolean.TRUE;
    }





}
