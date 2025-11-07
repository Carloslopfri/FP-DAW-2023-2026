<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/employees">


<html>
<body>
	<h2>	Empleados de la Empresa	</h2>

		<xsl:for-each select="employee">
		<xsl:sort select="id" order="ascending"/>
			<p>	Empleado	<xsl:value-of select="id"/> 			
			<ul>
				<li>	Nombre: <xsl:value-of select="name"/>			</li>
				<li>	Departamento: <xsl:value-of select="department"/>			</li>
        <li>	Salario: <xsl:value-of select="salary"/>			</li>
				<li>	Antiguedad: <xsl:value-of select="years_of_experience"/>			</li>
						</ul>
						</p>
		</xsl:for-each>

</body>
</html>

</xsl:template>
</xsl:stylesheet>