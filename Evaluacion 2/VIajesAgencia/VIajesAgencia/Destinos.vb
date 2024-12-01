Imports System.IO

Public Class Destinos
    Dim filePath As String = "destinos.txt"
    Private Sub Destinos_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.CenterToScreen()
        Dim deleteColumn As New DataGridViewButtonColumn With {
            .Name = "Delete",
            .HeaderText = "Delete",
            .Text = "ELIMINAR",
            .UseColumnTextForButtonValue = True,
            .Width = 250
        }
        deleteColumn.DefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleCenter
        DataGridView1.Columns.Add(deleteColumn)
        DataGridView1.RowTemplate.Height = 30
        LoadDestinos()
    End Sub

    Private Sub Btnback_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        Me.Close()
        Viajes.Show()
    End Sub

    Private Sub BtnAdd_Click(sender As Object, e As EventArgs) Handles btnAdd.Click
        If RealizarComprobaciones() Then
            AddDestino()
            MessageBox.Show("Destino agregado corretamente")
            LoadDestinos()
        End If
    End Sub

    Public Function RealizarComprobaciones() As Boolean
        If txtGuia.Text = "" Or txtDestino.Text = "" Then
            MessageBox.Show("Por favor, rellene todos los campos")
            Return False
        End If
        If Not System.Text.RegularExpressions.Regex.IsMatch(txtDestino.Text, "^[a-zA-Z\s]+$") Or Not System.Text.RegularExpressions.Regex.IsMatch(txtGuia.Text, "^[a-zA-Z\s]+$") Then
            MessageBox.Show("El destino y el nombre del guía solo puede contener letras y espacios")
            Return False
        End If
        Return True
    End Function

    Public Sub AddDestino()
        Try
            Dim destino As String = txtDestino.Text
            Dim guia As String = txtGuia.Text

            Dim destinoCompleto As String = $"{destino}-{guia},"

            Using writer As New StreamWriter(filePath, True)
                writer.WriteLine(destinoCompleto)
            End Using
        Catch ex As Exception
            MessageBox.Show("Error: " + ex.Message)
        End Try
    End Sub


    Public Sub LoadDestinos()
        Dim dt As New DataTable()

        dt.Columns.Add("Destino")
        dt.Columns.Add("Guia")

        Try
            Using reader As New StreamReader(filePath)
                While Not reader.EndOfStream
                    Dim line As String = reader.ReadLine()
                    Dim destinoData As String() = line.Split(",")

                    For Each destino As String In destinoData
                        If Not String.IsNullOrWhiteSpace(destino) Then
                            Dim fields As String() = destino.Split("-")
                            If fields.Length >= 2 Then ' Ensure there are at least two fields
                                dt.Rows.Add(fields(0), fields(1))
                            End If
                        End If
                    Next
                End While
            End Using

            DataGridView1.DataSource = dt

        Catch ex As Exception
            MessageBox.Show("Error reading file: " & ex.Message)
        End Try
    End Sub

    Private Sub DataGridViewDestinos_CellContentClick(sender As Object, e As DataGridViewCellEventArgs) Handles DataGridView1.CellContentClick
        If e.ColumnIndex = DataGridView1.Columns("Delete").Index Then
            Dim result As DialogResult = MessageBox.Show("Estas seguro que quieres eliminar este destino?", "Confirmation", MessageBoxButtons.YesNo)
            If result = DialogResult.Yes Then
                Dim destino As String = DataGridView1.Rows(e.RowIndex).Cells("Destino").Value.ToString()
                If EliminarDestino(destino) Then
                    MessageBox.Show("Destino eliminado correctamente")
                End If
                LoadDestinos()
            End If
        End If
    End Sub

    Public Function EliminarDestino(destino As String) As Boolean
        If Not File.Exists(filePath) Then
            MessageBox.Show("El fichero no existe.")
            Return False
        End If

        Dim lineas As List(Of String) = File.ReadAllLines(filePath).ToList()
        Using writer As New StreamWriter(filePath, False)
            For Each linea As String In lineas
                If Not linea.StartsWith(destino) Then
                    writer.WriteLine(linea)
                End If
            Next
        End Using
        Return True
    End Function
End Class