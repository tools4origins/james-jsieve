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

package org.apache.jsieve;

import org.apache.jsieve.parser.generated.Token;

/**
 * <p>A parsed representation of an RFC3028 TAG argument...</p>
 * 
 * <code>tag = ":" identifier</code>
 */
public class TagArgument implements Argument
{
    
    /**
     * The Tag
     */ 
    private String fieldTag;

    /**
     * Constructor for TagArgument.
     */
    private TagArgument()
    {
        super();
    }
    
    /**
     * Constructor for TagArgument.
     * @param token
     */
    public TagArgument(Token token)
    {
        this();
        setTag(token);
    }

    /**
     * Method setTag.
     * @param token
     */
    protected void setTag(Token token)
    {
        setTag(token.image);
    }
    

    /**
     * Returns the tag.
     * @return String
     */
    public String getTag()
    {
        return fieldTag;
    }

    /**
     * Sets the tag.
     * @param tag The tag to set
     */
    protected void setTag(String tag)
    {
        fieldTag = tag;
    }

    /**
     * @see org.apache.jsieve.Argument#getValue()
     */
    public Object getValue()
    {
        return getTag();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return (getValue() == null) ? "null" : getValue().toString();
    }

}
