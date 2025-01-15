Imports System.IO
Imports System.Xml

Public Class Ejercicio5
    Private Sub Ejercicio5_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.CenterToScreen()
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        LoadXML()
    End Sub

    Public Sub LoadXML()
        ' Define the file path
        Dim filePath As String = System.IO.Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments), "path.xml")


        ' Check if the file exists
        If File.Exists(filePath) Then
            ' Delete the existing file
            File.Delete(filePath)
        End If

        ' Create the XML document
        Dim xmlDoc As New XDocument(
            New XDeclaration("1.0", "utf-8", Nothing),  ' XML declaration
            New XElement("Asignaturas",  ' Root element
                New XElement("Asignatura",  ' First Asignatura element
                    New XAttribute("id", "Acceso a Datos"),  ' Attribute
                    New XElement("horario", "MAÑANA"),  ' Child element
                    New XElement("horas", "100")  ' Child element
                ),
                New XElement("Asignatura",  ' Second Asignatura element
                    New XAttribute("id", "Bases de Datos"),  ' Attribute
                    New XElement("horario", "MAÑANA"),  ' Child element
                    New XElement("horas", "60")  ' Child element
                )
            )
        )

        ' Save the XML document to a file
        xmlDoc.Save("hello.xml")
        MsgBox("Hello")

    End Sub

End Class