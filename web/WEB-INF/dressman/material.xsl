<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="https://dressmann.com">
    <xsl:output encoding="UTF-8" method="xml" omit-xml-declaration="yes" indent="yes"/>
    <xsl:template match="/">
        <materials>
            <xsl:for-each select="//div[@class='sizeguide text']/table/tbody/tr[position() >1]">
                <material>
                    <fiber>
                        <xsl:value-of select="td/strong"/>
                    </fiber>
                    <uses>
                        <xsl:value-of select="td[2]"/>
                    </uses>
                    <appearance>
                        <xsl:value-of select="td[3]"/>
                    </appearance>
                    <pros>
                        <xsl:value-of select="td[4]"/>
                    </pros>
                    <cons>
                        <xsl:value-of select="td[5]"/>
                    </cons>
                    <carewash>
                        <xsl:value-of select="td[6]"/>
                    </carewash>
                    <wrinkle>
                        <xsl:value-of select="td[7]"/>
                    </wrinkle>
                    <shrink>
                        <xsl:value-of select="td[8]"/>
                    </shrink>
                </material>
            </xsl:for-each>
        </materials>
    </xsl:template>

</xsl:stylesheet>