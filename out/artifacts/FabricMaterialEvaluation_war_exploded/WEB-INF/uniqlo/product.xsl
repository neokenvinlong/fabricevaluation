<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="https://www.uniqlo.com">
    <xsl:output encoding="UTF-8" method="xml" omit-xml-declaration="yes" indent="yes"/>
    <xsl:template match="/">
        <!--<xsl:for-each select="//div[@id='main']">-->
        <product>
            <productid>
                <xsl:value-of select="//span[@class='breadcrumb-productid']"/>
            </productid>
            <productname>
                <xsl:choose>
                    <xsl:when test="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@id='product-content']/div[@class='seoproduct']/h1">
                        <xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@id='product-content']/div[@class='seoproduct']/h1"/>
                    </xsl:when>
                    <xsl:when test="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@id='product-content']/div[@class='seoproduct']/h1/span">
                        <xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@id='product-content']/div[@class='seoproduct']/h1/span"/>
                    </xsl:when>
                </xsl:choose>
                <!--<xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@id='product-content']/div[@class='seoproduct']/h1"/>-->
                <!--<xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@id='product-content']/div[@class='seoproduct']/h1/span"/>-->
            </productname>
            <!--<productimages>-->
                <!--<xsl:for-each select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-1 product-image-container']/div[@class='product-image-container-images']/div[@id='thumbnails']/div[@class='product-left-zoom slick-initialized slick-slider slick-vertical']/div[@class='slick-list draggable']/div[@class='slick-track']">-->
                    <!--<productimage>-->
                        <!--<xsl:value-of select="/div/a/@href"/>-->
                    <!--</productimage>-->
                <!--</xsl:for-each>-->
            <!--</productimages>-->
            <productimage>
                <xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-1 product-image-container']/div[@class='product-image-container-images']/div[@class='product-primary-image']/a/@href"/>
            </productimage>
            <price>
                <xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@id='product-content']/div[@class='seoproduct']/div[@class='product-price']/span[@class='price-sales pdp-space-price sale-price-only' or @class='price-sales pdp-space-price']"/>
            </price>
            <sizes>
                <xsl:for-each select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@id='product-content']/div[@class='seoproduct']/div[@class='product-variations']/ul/li[2]/div[@class='value']/ul[@class='swatches size']/li[position() > 0]">
                    <size>
                        <xsl:value-of select="a"/>
                    </size>
                </xsl:for-each>
            </sizes>
            <!--<size>-->
                <!--<xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@id='product-content']/div[@class='seoproduct']/div[@class='product-variations']/ul/li[2]/div[@class='value']/ul[@class='swatches size']/li[position() > 0]"/>-->
            <!--</size>-->
            <productinfo>
                <xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@class='product-info']/div[@class='tabs']/div[@class='tab-content']/div[@class='tab-content1 tab-content-item']/span[@class='tab-content-text']"/>
                <xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@class='product-info']/div[@class='tabs']/div[@class='tab-content']/div[@class='tab-content1 tab-content-item']/span[@class='tab-content-text']/p"/>
                <xsl:value-of select="//div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@class='product-info']/div[@class='tabs']/div[@class='tab-content']/div[@class='tab-content1 tab-content-item']/span[@class='tab-content-text']/ul/li[position() > 0]"/>
            </productinfo>
            <material>
                <xsl:value-of select="//div[@id='main']/div[@id='primary']/div[@id='pdpMain']/div[@class='product-col-2 product-detail']/div[@class='product-info']/div[@class='tabs']/div[@class='tab-content']/div[@class='tab-content2 hide tab-content-item']/span[@class='tab-content-text']/ul/li[position() > 0]"/>
            </material>
        </product>
        <!--</xsl:for-each>-->
    </xsl:template>

</xsl:stylesheet>