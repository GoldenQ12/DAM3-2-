Imports System.Xml

Public Class DatosBarco

    Private Sub DatosBarco_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.CenterToScreen()
        LoadXml()
    End Sub


    Public Sub LoadXml()
        Dim doc As New XmlDocument()

        doc.Load("Barcos.xml")

        Dim barcos As XmlNodeList = doc.GetElementsByTagName("barco")

        For Each barco As XmlNode In barcos
            Dim mat As String = barco.Attributes("matricula").Value
            Dim codCap As Integer = barco("codigoCapitan").InnerText
            Dim eslora As Integer = barco("eslora").InnerText
            Dim tripulantes As Integer = barco("tripulantes").InnerText
            Dim bandera As String = barco("bandera")?.InnerText
            Dim fechaConstruccion As String = barco("fechaConstruccion")?.InnerText
            ListBox1.Items.Add($"{mat} {eslora} {tripulantes} {fechaConstruccion} {bandera} {codCap} ")
        Next
    End Sub



    Private Sub ListBox1_DoubleClick(sender As Object, e As EventArgs) Handles ListBox1.DoubleClick
        Dim extractedText As String = ListBox1.SelectedItem
        Dim parts As String() = extractedText.Split(New Char() {" "c}, StringSplitOptions.RemoveEmptyEntries)
        Dim form As New Ejercicio4()
        form.GetData(parts(0))
        form.Show()
    End Sub
End Class