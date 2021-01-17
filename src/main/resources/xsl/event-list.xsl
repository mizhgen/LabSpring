<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Events</title>
            </head>
            <body>
                <div class="header">
                    <div class="header-link">
                        <a href="/address" >Addresses</a>
                    </div>
                </div>
                <table  border="1">
                    <tr>
                        <td><strong>title</strong></td>
                        <td><strong>date</strong></td>
                        <td><strong>time</strong></td>
                        <td><strong>address</strong></td>
                    </tr>
                    <xsl:for-each select="ArrayList/item">
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="time"/></td>
                            <td><xsl:value-of select="date"/></td>
                            <td><xsl:value-of select="address/city"/></td>
                            <td><xsl:value-of select="address/street"/></td>
                            <td><xsl:value-of select="address/building"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>