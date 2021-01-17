<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Addresses</title>
            </head>
            <body>
                <div class="header">
                    <div class="header-link">
                        <a href="/events" >Events</a>
                    </div>
                </div>
                <table  border="1">
                    <tr>
                        <td><strong>City</strong></td>
                        <td><strong>Street</strong></td>
                        <td><strong>Building</strong></td>
                    </tr>
                    <xsl:for-each select="ArrayList/item">
                        <tr>
                            <td><xsl:value-of select="city"/></td>
                            <td><xsl:value-of select="street"/></td>
                            <td><xsl:value-of select="building"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>