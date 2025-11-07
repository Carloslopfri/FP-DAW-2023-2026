<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/inventario">
<html>
<style>
.available{color:#30ff06;}
.not{color:#ff0606;}
</style>
<body>
<h1>Inventario Productos</h1>
<xsl:for-each select="item">
<xsl:sort select="name" order="ascending"/>
<h2><xsl:value-of select="name"/></h2>
<img src="imagenes/{@id}.png" alt="No está"/>
<p><xsl:value-of select="brand"/> - <xsl:value-of select="category"/></p>
<p>Price: $<xsl:value-of select="price"/></p>
<xsl:choose>
<xsl:when test="available = 'true'">
<p class="available">Available</p>
</xsl:when>
<xsl:when test="available = 'false'">
<p class="not">Out of Stock</p>
</xsl:when>
</xsl:choose>
</xsl:for-each>
<table border="1">
<tr>
<th>Nombre</th>
<th>Marca</th>
<th>Categoría</th>
<th>Precio</th>
<th>Disponibilidad</th>
</tr>
<xsl:for-each select="item">
<xsl:sort select="available" order="descending"/>
<tr>
<td><xsl:value-of select="name"/></td>
<td><xsl:value-of select="brand"/></td>
<td><xsl:value-of select="category"/></td>
<td>$<xsl:value-of select="price"/></td>
<td>
<xsl:choose>
<xsl:when test="available = 'true'">
<p class="available">Available</p>
</xsl:when>
<xsl:when test="available = 'false'">
<p class="not">Out of Stock</p>
</xsl:when>
</xsl:choose>
</td>
</tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>