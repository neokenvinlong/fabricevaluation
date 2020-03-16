<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="UTF-8" method="xml" omit-xml-declaration="yes" indent="yes"/>
    <xsl:variable name="split">thanhdeptrai</xsl:variable>
    <xsl:template match="/">
        <xsl:for-each select="//div[@class='collections-section']/div/ul[@id='search-result-items']/li/div[@class='product-tile']/div[@class='product-tile-info']/div[@class='product-name']/a">
<!--            <productcategory>
                <xsl:value-of select="//div[@class='collections-section']/div/ul[@id='search-result-items']/li/div[@class='product-tile']/div[@class='product-tile-info']/div[@class='product-name']/a"/>
            </productcategory>-->
            <xsl:value-of select="@href"/><xsl:value-of select="$split"/>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>