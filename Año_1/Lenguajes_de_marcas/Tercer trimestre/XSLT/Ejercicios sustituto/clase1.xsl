<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/inventario">


<html>
<body>
	<h2>	INVENTARIO	</h2>

		<xsl:for-each select="producto">
			<p>	Producto	<xsl:value-of select="@codigo"/> 			
			<ul>
				<li>	Nombre: <xsl:value-of select="nombre"/>			</li>
				<li>	<xsl:value-of select="peso"/>	
					<xsl:value-of select="peso/@unidad"/>		</li>
				<li>	<xsl:value-of select="precio"/>			</li>
				<li>	<xsl:value-of select="unidades"/>		</li>


						</ul>
						</p>
		
		</xsl:for-each>

		<table border="1">
				<tr bgcolor="#b7fefc">
				<th> Código </th>
				<th> Peso </th>
				<th> Precio </th>
				<th> Unidades </th>
				</tr>
			<xsl:for-each select="producto">
					<tr>
				<td> <xsl:value-of select="@codigo"/> </td>
				<td> <xsl:value-of select="peso"/>	
					<xsl:value-of select="peso/@unidad"/> </td>
				<td> <xsl:value-of select="precio"/> </td>
				<td> <xsl:value-of select="unidades"/> </td>
					</tr>
			</xsl:for-each>
			

		</table>




</body>
</html>

</xsl:template>
</xsl:stylesheet>