<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/datos">
<html>
<body>
<h1>Lista de Sitios:</h1>
<ol>
<xsl:for-each select="elemento">
<li><a href="{url}"><xsl:value-of select="nombre"/></a> - <xsl:value-of select="descripcion"/></li>
</xsl:for-each>
</ol>
<h1>Tabla de Sitios Web Relevantes:</h1>
<table>
    <tr>
        <td>Celda 1</td>
        <td>Celda 2</td>
        <td>Celda 3</td>
    </tr>
    <tr>
        <td>Celda 4</td>
        <td>Celda 5</td>
    </tr>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>