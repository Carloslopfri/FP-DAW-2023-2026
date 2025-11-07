<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/ejercicios/ejercicio3">
    <html>
      <body>
      <xsl:variable name="a" select="a"/>
      <xsl:variable name="b" select="b"/>
      <xsl:variable name="c" select="c"/>
      <p>La ecuación que vamos a resolver es:<xsl:value-of select="$a"/> x +(<xsl:value-of select="$b"/>) = <xsl:value-of select="$c"/></p>
      <xsl:variable name="ti" select="$c - $b"/>
      <xsl:variable name="x" select="$ti div $a"/>
      <p>El resultado de la ecuación es x=<xsl:value-of select="$x"/></p>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>



