package org.apache.maven.doxia.siterenderer;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDefinitionDescription;
import com.gargoylesoftware.htmlunit.html.HtmlDefinitionList;
import com.gargoylesoftware.htmlunit.html.HtmlDefinitionTerm;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlHeading2;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlOrderedList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlPreformattedText;

import java.util.Iterator;


/**
 *
 * @author ltheussl
 * @version $Id$
 */
public class FaqVerifier
    extends AbstractVerifier
{
    /** {@inheritDoc} */
    public void verify( String file )
            throws Exception
    {
        HtmlPage page = htmlPage( file );
        assertNotNull( page );

        HtmlElement element = page.getHtmlElementById( "contentBox" );
        assertNotNull( element );
        HtmlDivision division = (HtmlDivision) element;
        assertNotNull( division );

        Iterator<HtmlElement> elementIterator = division.getHtmlElementDescendants().iterator();

        // ----------------------------------------------------------------------
        //
        // ----------------------------------------------------------------------

        HtmlDivision div = (HtmlDivision) elementIterator.next();
        assertEquals( div.getAttribute( "class" ), "section" );

        HtmlHeading2 h2 = (HtmlHeading2) elementIterator.next();
        assertEquals( h2.asText().trim(), "Oft Asked Questions" );

        HtmlAnchor a = (HtmlAnchor) elementIterator.next();
        assertEquals( "Oft_Asked_Questions", a.getAttribute( "name" ) );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( "top", a.getAttribute( "name" ) );

        HtmlParagraph p = (HtmlParagraph) elementIterator.next();
        element = elementIterator.next();
        assertEquals( element.getTagName(), "b" );
        assertEquals( element.asText().trim(), "Contributing" );

        HtmlOrderedList ol = (HtmlOrderedList) elementIterator.next();
        assertEquals( ol.getFirstChild().asText().trim(), "One stupid question & a silly answer?" );

        HtmlListItem li = (HtmlListItem) elementIterator.next();
        assertEquals( li.getFirstChild().asText().trim(), "One stupid question & a silly answer?" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "href" ), "#stupid-question" );

        element = elementIterator.next();
        assertEquals( element.getTagName(), "b" );
        assertEquals( element.asText().trim(), "stupid" );

        p = (HtmlParagraph) elementIterator.next();
        element = elementIterator.next();
        assertEquals( element.getTagName(), "b" );
        assertEquals( element.asText().trim(), "Using Maven" );

        ol = (HtmlOrderedList) elementIterator.next();
        assertEquals( ol.getFirstChild().asText().trim(), "How do I disable a report on my site?" );

        li = (HtmlListItem) elementIterator.next();
        assertNotNull( li );
        assertEquals( li.getFirstChild().asText().trim(), "How do I disable a report on my site?" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "href" ), "#disable-reports" );

        div = (HtmlDivision) elementIterator.next();
        assertEquals( div.getAttribute( "class" ), "section" );

        h2 = (HtmlHeading2) elementIterator.next();
        assertEquals( h2.asText().trim(), "Contributing" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "name" ), "Contributing" );

        HtmlDefinitionList dl = (HtmlDefinitionList) elementIterator.next();

        HtmlDefinitionTerm dt = (HtmlDefinitionTerm) elementIterator.next();
        assertEquals( dt.getFirstChild().asText().trim(), "One stupid question & a silly answer?" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "name" ), "stupid-question" );

        element = elementIterator.next();
        assertEquals( element.getTagName(), "b" );
        assertEquals( element.asText().trim(), "stupid" );

        HtmlDefinitionDescription dd = (HtmlDefinitionDescription) elementIterator.next();

        p = (HtmlParagraph) elementIterator.next();

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "href" ), "#Using_Maven" );
        assertEquals( a.asText().trim(), "local link" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "href" ), "./cdc.html" );
        assertEquals( a.asText().trim(), "source document" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "href" ), "http://maven.apache.org/?l=a&m=b" );
        assertEquals( a.asText().trim(), "external link" );

        element = elementIterator.next();
        assertEquals( element.getTagName(), "i" );
        assertEquals( element.asText().trim(), "italic" );

        p = (HtmlParagraph) elementIterator.next();
        assertEquals( p.getAttribute( "align" ), "right" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "href" ), "#top" );
        assertEquals( a.asText().trim(), "[top]" );


        div = (HtmlDivision) elementIterator.next();
        assertEquals( div.getAttribute( "class" ), "section" );

        h2 = (HtmlHeading2) elementIterator.next();
        assertEquals( h2.asText().trim(), "Using Maven" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "name" ), "Using_Maven" );

        dl = (HtmlDefinitionList) elementIterator.next();

        dt = (HtmlDefinitionTerm) elementIterator.next();
        assertEquals( dt.getFirstChild().asText().trim(), "How do I disable a report on my site?" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "name" ), "disable-reports" );

        dd = (HtmlDefinitionDescription) elementIterator.next();

        p = (HtmlParagraph) elementIterator.next();

        element = elementIterator.next();
        assertEquals( element.getTagName(), "tt" );
        assertEquals( element.asText().trim(), "<source></source>" );

        div = (HtmlDivision) elementIterator.next();
        assertEquals( div.getAttribute( "class" ), "source" );

        HtmlPreformattedText pre = (HtmlPreformattedText) elementIterator.next();
        assertEquals( pre.asText().trim(), "<source>1.5</source>" );

        p = (HtmlParagraph) elementIterator.next();
        assertEquals( p.getAttribute( "align" ), "right" );

        a = (HtmlAnchor) elementIterator.next();
        assertEquals( a.getAttribute( "href" ), "#top" );
        assertEquals( a.asText().trim(), "[top]" );

        assertFalse( elementIterator.hasNext() );
    }
}
