<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/employees">


<html>
<body>
	<h2 >	Empleados de la empresa	</h2>

		<xsl:for-each select="employee">
		<xsl:if test="salary > 56000" >
			<p>	Empleado	<xsl:value-of select="id"/> 			
			<ul>
				<li>	Nombre: <xsl:value-of select="name"/>			</li>
				<li>	Departamento: <xsl:value-of select="department"/>		</li>
				<li>	salario: <xsl:value-of select="salary"/>			</li>
				<li>	antigüedad:<xsl:value-of select="years_of_experience"/>		</li>
      </ul>
      </p>
    </xsl:if>
		</xsl:for-each>
solo aquellos con salario igual o superior a 55000
<!--solo aquellos con salario superior a 55000-->

		<table border="1">
				<tr bgcolor="#000000">
				<th><p style="color:#ffffff"> Empleado </p></th>
				<th><p style="color:#ffffff"> Nombre</p> </th>
				<th><p style="color:#ffffff"> Departamento </p></th>
        <th><p style="color:#ffffff"> Salario </p> </th>
        <th><p style="color:#ffffff"> Antigüedad </p> </th>
				</tr>
			<xsl:for-each select="employee">
			<xsl:choose>
			  <xsl:when test="not(years_of_experience > 4)">
        <tr bgcolor="#a2d895">
				<td> <xsl:value-of select="id"/> </td>
				<td> <xsl:value-of select="name"/> </td>
				<td> <xsl:value-of select="department"/> </td>
				<td> <xsl:value-of select="salary"/> </td>
				<td> <xsl:value-of select="years_of_experience"/> </td>
        </tr>
        </xsl:when>
        <xsl:when test="years_of_experience >=7">
        <tr bgcolor="#e48897">
        <td> <xsl:value-of select="id"/> </td>
				<td> <xsl:value-of select="name"/> </td>
				<td> <xsl:value-of select="department"/> </td>
				<td> <xsl:value-of select="salary"/> </td>
				<td> <xsl:value-of select="years_of_experience"/> </td>
				</tr>
        </xsl:when>
        <xsl:otherwise>
        <tr bgcolor="#e6dc92">
        <td> <xsl:value-of select="id"/> </td>
				<td> <xsl:value-of select="name"/> </td>
				<td> <xsl:value-of select="department"/> </td>
				<td> <xsl:value-of select="salary"/> </td>
				<td> <xsl:value-of select="years_of_experience"/> </td>
        
        </tr>
        </xsl:otherwise>
					
      </xsl:choose>
			</xsl:for-each>
			

		</table>

#a2d895
#e6dc92
#e48897


</body>
</html>

</xsl:template>
</xsl:stylesheet>




