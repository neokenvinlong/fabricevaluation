<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="https://www.uniqlo.com">
    <xsl:output encoding="UTF-8" method="xml" omit-xml-declaration="yes" indent="yes"/>
    <xsl:variable name="website">https://www.uniqlo.com</xsl:variable>
    <xsl:template match="/">

        <categories>
            <xsl:for-each select="//*[@id='navigation']/ul/li[3]//ul[position() = 2]/li[position() > 1]">
                <category>
                    <name>
                        <xsl:value-of select="a"/>
                    </name>
                    <url>
                        <xsl:value-of select="$website"/><xsl:value-of select="a/@href"/>
                    </url>
                </category>
            </xsl:for-each>
            <xsl:for-each select="//*[@id='navigation']/ul/li[3]//ul[position() = 3]/li[position() > 2 and position() &lt; 8]">
                <category>
                    <name>
                        <xsl:value-of select="a"/>
                    </name>
                    <url>
                        <xsl:value-of select="$website"/><xsl:value-of select="a/@href"/>
                    </url>
                </category>
            </xsl:for-each>
            <xsl:for-each select="//*[@id='navigation']/ul/li[3]//ul[position() = 4]/li[position() > 1]">
                <category>
                    <name>
                        <xsl:value-of select="a"/>
                    </name>
                    <url>
                        <xsl:value-of select="$website"/><xsl:value-of select="a/@href"/>
                    </url>
                </category>
            </xsl:for-each>
        </categories>
    </xsl:template>

</xsl:stylesheet>