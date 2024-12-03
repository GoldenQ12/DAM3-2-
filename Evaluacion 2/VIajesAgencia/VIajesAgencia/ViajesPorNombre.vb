Imports System.IO

Public Class ViajesPorNombre
    Dim filePath As String = "viaje.txt"
    Dim filePathClientes As String = "clientes.txt"
    Private Sub ViajesPorNombre_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.CenterToScreen()
        LoadData()
        LoadClientes(filePathClientes)
    End Sub

    Public Sub LoadData()
        Dim dt As New DataTable()

        dt.Columns.Add("Nombre")
        dt.Columns.Add("Destino")
        dt.Columns.Add("Fecha")

        Try
            Using reader As New StreamReader(filePath)
                While Not reader.EndOfStream
                    Dim line As String = reader.ReadLine()
                    Dim viajeData As String() = line.Split("#")

                    For Each viaje As String In viajeData
                        If Not String.IsNullOrWhiteSpace(viaje) Then
                            Dim fields As String() = viaje.Split("-")
                            If fields.Length >= 2 Then
                                dt.Rows.Add(fields(0), fields(1), fields(2))
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

    Public Sub LoadDataByNombre(ByVal nombre As String)
        Dim dt As New DataTable()

        dt.Columns.Add("Nombre")
        dt.Columns.Add("Destino")
        dt.Columns.Add("Fecha")

        Try
            Using reader As New StreamReader(filePath)
                While Not reader.EndOfStream
                    Dim line As String = reader.ReadLine()
                    Dim viajeData As String() = line.Split("#")

                    For Each viaje As String In viajeData
                        If Not String.IsNullOrWhiteSpace(viaje) Then
                            Dim fields As String() = viaje.Split("-")
                            If line.StartsWith(nombre) Then
                                dt.Rows.Add(fields(0), fields(1), fields(2))
                            End If
                        End If
                    Next
                End While
            End Using
            DataGridView1.DataSource = dt
            If dt.Rows.Count <= 0 Then
                MessageBox.Show($"El cliente {nombre} no tiene viajes")
                LoadData()
            End If

        Catch ex As Exception
            MessageBox.Show("Error reading file: " & ex.Message)
        End Try
    End Sub

    Private Sub btnSearch_Click(sender As Object, e As EventArgs) Handles btnSearch.Click
        Dim cliente As String = listBoxClientes.SelectedItem
        If cliente Is Nothing Then
            MessageBox.Show("Por favor, seleccione un cliente")
            cliente = ""
        End If
        LoadDataByNombre(cliente)
    End Sub

    Private Sub btnBack_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        Me.Close()
        Viajes.Show()
    End Sub

    Private Sub LoadClientes(filePath As String)
        If Not File.Exists(filePath) Then
            MessageBox.Show("File not found: " & filePath)
            Return
        End If

        Using reader As New StreamReader(filePath)
            While Not reader.EndOfStream
                Dim line As String = reader.ReadLine().Trim()
                If Not String.IsNullOrWhiteSpace(line) Then
                    Dim parts As String() = line.Split("€"c)

                    Dim firstName As String = parts(0).Trim()
                    Dim secondName As String = parts(1).Trim()

                    Dim fullName As String = $"{firstName} {secondName}"
                    listBoxClientes.Items.Add(fullName)

                End If
            End While
        End Using
    End Sub

    Private Sub BtrnSelect_Click(sender As Object, e As EventArgs) Handles btrnSelect.Click
        Dim openFileDialog As New OpenFileDialog()

        ' Configurar las propiedades del cuadro de diálogo
        openFileDialog.Filter = "Archivos de texto (*.txt)|*.txt|Todos los archivos (*.*)|*.*"
        openFileDialog.Title = "Seleccionar un archivo"

        ' Mostrar el cuadro de diálogo y verificar si el usuario hizo clic en "Abrir"
        If openFileDialog.ShowDialog() = DialogResult.OK Then
            filePath = openFileDialog.FileName
        End If

        LoadData()
    End Sub
End Class