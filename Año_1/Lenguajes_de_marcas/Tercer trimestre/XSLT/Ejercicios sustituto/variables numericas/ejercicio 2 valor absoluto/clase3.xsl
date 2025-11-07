<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/ejercicios/ejercicio2">
    <html>
      <body>
      <xsl:variable name="a" select="num1"/>
      <xsl:variable name="b" select="num2"/>
      <p>a=<xsl:value-of select="$a"/> </p>
      <p>b=<xsl:value-of select="$b"/> </p>
      <xsl:variable name="resta" select="$a - $b"/>
      <p>resta=<xsl:value-of select="$resta"/> </p>
      <xsl:choose>
      <xsl:when test="$resta >= 0">
        <p>el valor absoluto es:<xsl:value-of select="$resta"/></p>
      </xsl:when>
      <xsl:otherwise>
        <p>el valor absoluto es:<xsl:value-of select="-$resta"/></p>
      </xsl:otherwise>
      </xsl:choose>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>



