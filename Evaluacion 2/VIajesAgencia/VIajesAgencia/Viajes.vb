Public Class Viajes
    Private Sub Viajes_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.CenterToScreen()
    End Sub

    Private Sub BtnClientes_Click(sender As Object, e As EventArgs) Handles btnClientes.Click
        Me.Hide()
        Clientes.Show()
    End Sub

    Private Sub btnBack_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        Me.Close()
    End Sub

    Private Sub BtnDestinos_Click(sender As Object, e As EventArgs) Handles btnDestinos.Click
        Me.Hide()
        Destinos.Show()
    End Sub

    Private Sub btnViajes_Click(sender As Object, e As EventArgs) Handles btnViajes.Click
        Me.Hide()
        ViajesRegistros.Show()
    End Sub
End Class
