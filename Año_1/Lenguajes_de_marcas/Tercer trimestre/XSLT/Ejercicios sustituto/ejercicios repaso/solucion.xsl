<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/library">
<html>
<style>
.available{color:#30ff06;}
.not{color:#ff0606;}
</style>
<body>
<h1>Library Catalog:</h1>
<xsl:for-each select="book">
<h2><xsl:value-of select="title"/></h2>
<p><xsl:value-of select="author"/> - <xsl:value-of select="genre"/></p>
<p>Price: $<xsl:value-of select="price"/></p>
<xsl:choose>
<xsl:when test="available = 'true'">
<p class="available">Available</p>
</xsl:when>
<xsl:when test="available = 'false'">
<p class="not">Out of Stock</p>
</xsl:when>
</xsl:choose>
<h3>Review</h3>
<ul>
<xsl:for-each select="reviews/review">
<li><a><xsl:value-of select="user"/> : <xsl:value-of select="comment"/></a></li>
</xsl:for-each>
</ul>
</xsl:for-each>
<h1>Library Catalog:</h1>
<table border="1">
<tr>
<th>Title</th>
<th>Author</th>
<th>Genre</th>
<th>Price</th>
<th>Available</th>
<th>Reviews</th>
</tr>
<xsl:for-each select="book">
<tr>
<td><xsl:value-of select="title"/></td>
<td><xsl:value-of select="author"/></td>
<td><xsl:value-of select="genre"/></td>
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
<td>
<ul>
<xsl:for-each select="reviews/review">
<li><a><xsl:value-of select="user"/> : <xsl:value-of select="comment"/></a></li>
</xsl:for-each>
</ul>
</td>
</tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>