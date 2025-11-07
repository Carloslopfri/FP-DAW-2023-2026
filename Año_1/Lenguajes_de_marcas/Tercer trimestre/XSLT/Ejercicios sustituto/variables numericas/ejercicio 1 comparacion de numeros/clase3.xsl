<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/ejercicios/ejercicio1">
    <html>
      <body>
      <xsl:variable name="a" select="num1"/>
      <xsl:variable name="b" select="num2"/>
      <p>a=<xsl:value-of select="$a"/> </p>
      <p>b=<xsl:value-of select="$b"/> </p>
      <xsl:choose>
      <xsl:when test="$a > $b">
        <p>a es mayor que b</p>
      </xsl:when>
      <xsl:when test="$a = $b">
        <p>a es igual a b</p>
      </xsl:when>
      <xsl:otherwise>
        <p> b es mayor que a</p>
      </xsl:otherwise>
      </xsl:choose>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>



