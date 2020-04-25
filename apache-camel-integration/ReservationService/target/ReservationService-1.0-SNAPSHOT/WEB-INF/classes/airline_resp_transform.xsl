<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:resa="http://aira.sample.com/quote/"
	xmlns:resb="http://airb.sample.com/quote/" xmlns:quot="http://air.sample.com/quote/">

	<xsl:output method="xml" omit-xml-declaration="yes" indent="yes"
		encoding="UTF-8" />

	<xsl:template match="text()|@*" />

	<xsl:template match="//resa:getQuoteResponse//getQuoteResponse//price">
		<xsl:element name="quot:getQuoteResponse">
			<xsl:element name="getQuoteResponse">
				<xsl:element name="price">
					<xsl:element name="airLine">
						<xsl:value-of select="//price//airLine"></xsl:value-of>
					</xsl:element>
					<xsl:element name="price">
						<xsl:value-of select="//price//price"></xsl:value-of>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>

	<xsl:template match="//resb:getQuoteResponse//getQuoteResponse//price">
		<xsl:element name="quot:getQuoteResponse">
			<xsl:element name="getQuoteResponse">
				<xsl:element name="price">
					<xsl:element name="airLine">
						<xsl:value-of select="//price//airLine"></xsl:value-of>
					</xsl:element>
					<xsl:element name="price">
						<xsl:value-of select="//price//price"></xsl:value-of>
					</xsl:element>
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>

</xsl:stylesheet>