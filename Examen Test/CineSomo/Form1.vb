Public Class Form1

    Public Property pelicula As Pelicula = New Pelicula()

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        pelicula.Nombre = lbl1.Text
        pelicula.Director = "Jose Luis"
        pelicula.Actores = {"Pedro", "Jimena", "Jose"}
        pelicula.Duracion = 120
        pelicula.Anio = 2020
        Me.Hide()
        Form2.Show()
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click
        pelicula.Nombre = lbl2.Text
        pelicula.Director = "Jon Ander"
        pelicula.Actores = {"Iker", "Haimar"}
        pelicula.Duracion = 100
        pelicula.Anio = 2018
        Me.Hide()
        Form2.Show()
    End Sub

    Private Sub Button4_Click(sender As Object, e As EventArgs) Handles Button4.Click
        pelicula.Nombre = lbl3.Text
        pelicula.Director = "Alex Garai"
        pelicula.Actores = {"Angel", "Erlantz", "Lander", "Ivan"}
        pelicula.Duracion = 200
        pelicula.Anio = 2023
        Me.Hide()
        Form2.Show()
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub

    Private Sub btnBack_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        Me.Close()
    End Sub

    Private Sub Label3_Click(sender As Object, e As EventArgs) Handles Label3.Click

    End Sub

    Private Sub FlowLayoutPanel1_Paint(sender As Object, e As PaintEventArgs) Handles FlowLayoutPanel1.Paint

    End Sub
End Class
