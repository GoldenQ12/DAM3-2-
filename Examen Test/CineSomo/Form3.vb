Imports System.IO

Public Class Form3
    Dim random As New Random()
    Public Property sala As Sala = New Sala(random.Next(1, 200))
    Private Sub btnBack_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        Form2.Show()
        Me.Close()
    End Sub

    Private Sub btnComprar_Click(sender As Object, e As EventArgs) Handles btnComprar.Click
        If sala.Entradas = 200 Then
            MsgBox("No puedes comprar entradas debido a que la sala esta llena")
        Else
            sala.Entradas += txtEntradas.Value
            If sala.Entradas >= 200 Then
                MsgBox("No puedes comprar entradas debido a que la sala esta llena")
                sala.Entradas = 200
                Label2.Text = "Entradas disponibles: " & sala.Entradas
            Else
                MsgBox("Entradas compradas correctamente")
                MsgBox("Generando ticket de compra... ")
                Try
                    Using sw As New StreamWriter("ticket.txt")
                        Dim ticket As Ticket = New Ticket(txtEntradas.Value, sala, lblHora.Text)
                        sw.WriteLine("Nombre de la pelicula: " & Form1.pelicula.Nombre & Environment.NewLine & ticket.ToString())
                    End Using
                    MsgBox("Ticket generado correctamente")
                Catch ex As Exception
                    MsgBox("Error al generar el ticket: " & ex.Message())
                End Try
            End If
            Label2.Text = "Entradas disponibles: " & sala.Entradas


        End If
    End Sub

    Private Sub Form3_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        lblInfo.Text = Form1.pelicula.ToString()
        lblHora.Text = Form2.hora
        Me.CenterToScreen()
    End Sub

    Private Sub Label3_Click(sender As Object, e As EventArgs) Handles lblInfo.Click

    End Sub
End Class