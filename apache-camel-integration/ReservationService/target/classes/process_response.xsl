<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:res="http://air.sample.com/quote/">

	<xsl:output method="xml" indent="yes" encoding="UTF-8" />

	<xsl:template match="text()|@*" />

	<xsl:template match="//aggregatedResponse">
		<xsl:element name="res:getQuoteResponse">
			<xsl:element name="getQuoteResponse">
				<xsl:for-each select="//res:getQuoteResponse">
					<xsl:element name="price">
						<xsl:element name="airLine">
							<xsl:value-of select="getQuoteResponse//price//airLine"></xsl:value-of>
						</xsl:element>
						<xsl:element name="price">
							<xsl:value-of select="getQuoteResponse//price//price"></xsl:value-of>
						</xsl:element>
					</xsl:element>
				</xsl:for-each>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>