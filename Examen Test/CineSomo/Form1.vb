Public Class Form1

    Public Property pelicula As Pelicula = New Pelicula()

    Private Sub BtnBack_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        Me.Close()
    End Sub


    Private Sub PictureBox1_Click(sender As Object, e As EventArgs) Handles PictureBox1.Click
        pelicula.Nombre = lbl1.Text
        pelicula.Director = "Jose Luis"
        pelicula.Actores = {"Pedro", "Jimena", "Jose"}
        pelicula.Duracion = 120
        pelicula.Anio = 2020
        Me.Hide()
        Form2.Show()
    End Sub

    Private Sub PictureBox2_Click(sender As Object, e As EventArgs) Handles PictureBox2.Click
        pelicula.Nombre = lbl2.Text
        pelicula.Director = "Jon Ander"
        pelicula.Actores = {"Iker", "Haimar"}
        pelicula.Duracion = 100
        pelicula.Anio = 2018
        Me.Hide()
        Form2.Show()
    End Sub

    Private Sub PictureBox3_Click(sender As Object, e As EventArgs) Handles PictureBox3.Click
        pelicula.Nombre = lbl3.Text
        pelicula.Director = "Alex Garai"
        pelicula.Actores = {"Angel", "Erlantz", "Lander", "Ivan"}
        pelicula.Duracion = 200
        pelicula.Anio = 2023
        Me.Hide()
        Form2.Show()
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.CenterToScreen()
    End Sub
End Class
