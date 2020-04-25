<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:res="http://air.sample.com/quote/"
	xmlns:quot="http://airb.sample.com/quote/">

	<xsl:output method="xml" indent="yes" encoding="UTF-8" />

	<xsl:template match="text()|@*" />


	<xsl:template match="//res:getQuote//getQuote">
		<xsl:element name="quot:getQuote">
			<xsl:element name="getQuote">
				<xsl:element name="source">
					<xsl:value-of select="source"></xsl:value-of>
				</xsl:element>
				<xsl:element name="destination">
					<xsl:value-of select="destination"></xsl:value-of>
				</xsl:element>
				<xsl:element name="date">
					<xsl:value-of select="date"></xsl:value-of>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>