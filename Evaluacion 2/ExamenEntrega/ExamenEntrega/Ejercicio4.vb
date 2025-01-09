Imports System.Xml

Public Class Ejercicio4
    Private Sub Ejercicio4_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.CenterToScreen()
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Me.Close()
        Examen.Show()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Me.Close()
        DatosBarco.Show()
    End Sub

    Public Sub GetData(mat As String)
        Dim doc As New XmlDocument()

        Try
            doc.Load("Barcos.xml")

            Dim barcoNode As XmlNode = doc.SelectSingleNode($"//barco[@matricula='{mat}']")

            txtMatricula.Text = mat
            txtCodigo.Text = barcoNode.SelectSingleNode("codigoCapitan")?.InnerText
            txtEslora.Text = barcoNode.SelectSingleNode("eslora")?.InnerText
            txtTripulantes.Text = barcoNode.SelectSingleNode("tripulantes")?.InnerText
            txtConstruido.Text = barcoNode.SelectSingleNode("fechaConstruccion")?.InnerText
            txtCapitan.Text = barcoNode.SelectSingleNode("bandera")?.InnerText
        Catch ex As Exception
            MessageBox.Show($"{ex.Message}")
        End Try
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click
        Dim doc As New XmlDocument()

        Try
            Dim cod As String = txtCodigo.Text
            doc.Load("capitanes.xml")

            Dim capitanNode As XmlNode = doc.SelectSingleNode($"//capitan[@codigo='{cod}']")

            txtApodo.Text = capitanNode.Attributes("apodo").Value
            txtNombre.Text = capitanNode.SelectSingleNode("nombre").InnerText
            txtFechaNac.Text = capitanNode.SelectSingleNode("fechaNacimiento").InnerText
            txtFechaCap.Text = capitanNode.SelectSingleNode("fechaCapitania").InnerText

        Catch ex As Exception
            MessageBox.Show($"{ex.Message}")
        End Try
    End Sub
End Class