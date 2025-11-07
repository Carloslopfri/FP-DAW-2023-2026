<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/clima">
<html>
<body>
<h1>El tiempo para Galicia - 26/04/2021</h1>
<table border="1">
<tr>
<th>Localidad</th>
<th>Previsión</th>
<th>T.MIN</th>
<th>T.MAX</th>
<th>Precipitación</th>
</tr>
<xsl:choose>
<xsl:when test="//@fecha='26/04/2021'">
<xsl:for-each select="prediccion">
<tr>
<td><xsl:value-of select="@loc"/></td>
<td><img src="imagenes/{@cl}.png" alt="No está"/></td>
<td><xsl:value-of select="min"/></td>
<td>$<xsl:value-of select="max"/></td>
<td><xsl:value-of select="lluvia"/>%</td>
</tr>
</xsl:for-each>
</xsl:when>
</xsl:choose>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>