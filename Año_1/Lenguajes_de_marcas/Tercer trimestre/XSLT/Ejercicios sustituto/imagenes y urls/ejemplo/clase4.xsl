<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <p> <a href="https://es.wikipedia.org/wiki/Wikipedia:Portada"> Yo lo se todo </a> </p>
                <xsl:for-each select="cosas/cosa">
                    <xsl:value-of select="."/>
                </xsl:for-each>
                <img src="imagen.jpg" alt="No está"/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>