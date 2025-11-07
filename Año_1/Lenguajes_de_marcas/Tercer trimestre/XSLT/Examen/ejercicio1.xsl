<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/nba">
<html>
<body>
<h1>Temporada<xsl:value-of select="temporada"/></h1>
<xsl:for-each select="equipo">
<h2>Equipo nº <xsl:value-of select="@id"/>:<xsl:value-of select="nombre"/></h2>
<ul>
<li><a><xsl:value-of select="ubicacion"/></a></li>
<li><a><xsl:value-of select="propietario"/></a></li>
<li><a><xsl:value-of select="entrenador"/></a></li>
<li><a><xsl:value-of select="estadio"/></a></li>
<li><a href="{url}"><xsl:value-of select="web"/></a></li>
<img src="https://www.mavs.com/wp-content/themes/mavs/images/logo.svg" alt="No está"/>
</ul>
</xsl:for-each>
<xsl:for-each select="plantilla">
<table border="1">
<h3>Plantilla nº <xsl:value-of select="@eq"/></h3>
<tr bgcolor="#FF4500">
<th>Jugador nº</th>
<th>Nombre</th>
<th>Puesto</th>
<th>Altura (cm)</th>
<th>Peso (kg)</th>
</tr>
<xsl:for-each select="jugador">
<xsl:sort select="puesto" order="ascending"/>
<tr>
<td><xsl:value-of select="@num"/></td>
<td><xsl:value-of select="nombre"/></td>
<td><xsl:value-of select="puesto"/></td>
<td><xsl:value-of select="altura"/></td>
<td><xsl:value-of select="peso"/></td>
</tr>
</xsl:for-each>
</table>
</xsl:for-each>
</body>
</html>
</xsl:template>
</xsl:stylesheet>