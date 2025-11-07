<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/employees">


<html>
<body>
	<h2 >	Empleados de la empresa	</h2>

		<xsl:for-each select="employee">
		<xsl:sort select="years_of_experience" order="descending"/>			
			<p>	Empleado	<xsl:value-of select="id"/> 			
			<ul>
				<li>	Nombre: <xsl:value-of select="name"/>			</li>
				<li>	Departamento: <xsl:value-of select="department"/>		</li>
				<li>	salario: <xsl:value-of select="salary"/>			</li>
				<li>	antigüedad:<xsl:value-of select="years_of_experience"/>		</li>
      </ul>
      </p>
		
		</xsl:for-each>

		<table border="1">
				<tr bgcolor="#000000">
				<th> <p style="color:#ffffff"> Empleado </p></th>
				<th><p style="color:#ffffff"> Nombre</p> </th>
				<th><p style="color:#ffffff"> Departamento </p></th>
        <th><p style="color:#ffffff"> Salario </p> </th>
        <th><p style="color:#ffffff"> Antigüedad </p> </th>
				</tr>
			<xsl:for-each select="employee">
        <xsl:sort select="name"/>
					<tr>
				<td> <xsl:value-of select="id"/> </td>
				<td> <xsl:value-of select="name"/> </td>
				<td> <xsl:value-of select="department"/> </td>
				<td> <xsl:value-of select="salary"/> </td>
				<td> <xsl:value-of select="years_of_experience"/> </td>
					</tr>
			</xsl:for-each>
			

		</table>




</body>
</html>

</xsl:template>
</xsl:stylesheet>




