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

package org.apache.jsieve.junit.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.jsieve.mail.SieveMailException;
import org.apache.jsieve.mail.optional.EnvelopeAccessors;

/**
 * <p>Class SieveEnvelopeMailAdapter extends class SieveMailAdapter, a mock 
 * implementation of a MailAdapter, to add support for EnvelopeAccessors.<p>
 * 
 * <p>As the Envelope Test is an optional Sieve test, MailAdapter support for the
 * interface is optional too.</p>
 */
public class SieveEnvelopeMailAdapter
    extends SieveMailAdapter
    implements EnvelopeAccessors
{
    /**
     * The FROM address used in the SMTP MAIL command.
     */
    private String fieldEnvelopeFrom;
    
    /**
     * The TO address used in the SMTP RCPT command that resulted in this message
     *  getting delivered to this user.
     */ 
    private String fieldEnvelopeTo;

    /**
     * Constructor for SieveEnvelopeMailAdapter.
     * @param message
     */
    public SieveEnvelopeMailAdapter(MimeMessage message)
    {
        super(message);
    }
    
    /**
     * Method getEnvelopes.
     * @return Map
     */
    protected Map getEnvelopes()
    {
        Map envelopes = new HashMap(2);
        if (null != getEnvelopeFrom())
            envelopes.put("From", getEnvelopeFrom());
        if (null != getEnvelopeTo())
            envelopes.put("To", getEnvelopeTo());
        return envelopes;
    }
        
    /**
     * @see org.apache.jsieve.mail.optional.EnvelopeAccessors#getEnvelope(String)
     */
    public List getEnvelope(String name) throws SieveMailException
    {
        List values = new ArrayList(1);
        Object value = getEnvelopes().get(name);
        if (null != value)
            values.add(value);
        return values;
    }

    /**
     * @see org.apache.jsieve.mail.optional.EnvelopeAccessors#getEnvelopeNames()
     */
    public List getEnvelopeNames() throws SieveMailException
    {
        return new ArrayList(getEnvelopes().keySet());
    }

    /**
     * @see org.apache.jsieve.mail.optional.EnvelopeAccessors#getMatchingEnvelope(String)
     */
    public List getMatchingEnvelope(String name) throws SieveMailException
    {
        Iterator envelopeNamesIter = getEnvelopeNames().iterator();
        List matchedEnvelopeValues = new ArrayList(32);
        while (envelopeNamesIter.hasNext())
        {
            String envelopeName = (String) envelopeNamesIter.next();
            if (envelopeName.trim().equalsIgnoreCase(name))
                matchedEnvelopeValues.addAll(getEnvelope(envelopeName));
        }

        return matchedEnvelopeValues;
    }

    /**
     * Returns the from.
     * @return String
     */
    public String getEnvelopeFrom()
    {
        return fieldEnvelopeFrom;
    }

    /**
     * Returns the recipient.
     * @return String
     */
    public String getEnvelopeTo()
    {
        return fieldEnvelopeTo;
    }

    /**
     * Sets the from.
     * @param from The from to set
     */
    public void setEnvelopeFrom(String from)
    {
        fieldEnvelopeFrom = from;
    }

    /**
     * Sets the recipient.
     * @param recipient The recipient to set
     */
    public void setEnvelopeTo(String recipient)
    {
        fieldEnvelopeTo = recipient;
    }

}
