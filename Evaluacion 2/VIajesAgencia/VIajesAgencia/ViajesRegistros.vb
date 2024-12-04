Imports System.IO

Public Class ViajesRegistros
    Dim filePath As String = ""
    Private Sub ViajesRegistros_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.CenterToScreen()
        LoadData()
    End Sub


    Private Sub LoadData()
        Dim destinosFilePath As String = "destinos.txt"
        Dim clientesFilePath As String = "clientes.txt"

        listBoxDestinos.Items.Clear()
        listBoxClientes.Items.Clear()

        Try
            LoadDestinos(destinosFilePath)
            LoadClientes(clientesFilePath)

        Catch ex As Exception
            MessageBox.Show("Error loading data: " & ex.Message)
        End Try
    End Sub

    Private Sub LoadDestinos(filePath As String)
        ' Check if the file exists
        If Not File.Exists(filePath) Then
            MessageBox.Show("File not found: " & filePath)
            Return
        End If

        Using reader As New StreamReader(filePath)
            While Not reader.EndOfStream
                Dim line As String = reader.ReadLine().Trim()
                If Not String.IsNullOrWhiteSpace(line) Then
                    Dim parts As String() = line.Split("-")
                    Dim destino As String = parts(0).Trim()
                    listBoxDestinos.Items.Add(destino)
                End If
            End While
        End Using
    End Sub

    Private Sub LoadClientes(filePath As String)
        ' Check if the file exists
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

    Private Sub btnBack_Click(sender As Object, e As EventArgs)
        Me.Close()
        Viajes.Show()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        SaveTravelAs()
    End Sub

    Public Sub SaveTravelAs()
        Dim destino As String = ""
        Dim cliente As String = ""
        destino = listBoxDestinos.SelectedItem
        cliente = listBoxClientes.SelectedItem
        Dim fecha As Date = New Date()
        fecha = Date.Parse(calendar.Text)
        Dim fechaActual As Date = DateTime.Now.ToShortDateString

        If fecha < fechaActual Then
            MessageBox.Show("No puedes añadir un viaje previo al dia actual")
            Return
        End If

        Dim destinoCompleto As String = $"{cliente}-{destino}-{fecha}#"

        Try
            If destino Is Nothing Or cliente Is Nothing Then
                MessageBox.Show("Por favor, seleccione todos los campos")
            Else
                Dim saveFileDialog As New SaveFileDialog()
                filePath = saveFileDialog.FileName

                saveFileDialog.Filter = "Text Files (*.txt)|*.txt"
                saveFileDialog.Title = "Guardar como"
                If saveFileDialog.ShowDialog() = DialogResult.OK Then
                    Using writer As New StreamWriter(saveFileDialog.FileName, True)
                        writer.WriteLine(destinoCompleto)
                    End Using
                    MessageBox.Show("Guardado correctamente")
                End If
            End If

        Catch ex As Exception
            MessageBox.Show("Error: " + ex.Message)
        End Try
    End Sub

    Private Sub BtnSelect_Click(sender As Object, e As EventArgs)
        SaveTravel()
    End Sub

    Public Sub SaveTravel()
        Dim destino As String = listBoxDestinos.SelectedItem
        Dim cliente As String = listBoxClientes.SelectedItem
        Dim fecha As String = calendar.Text

        Dim destinoCompleto As String = $"{cliente}-{destino}-{fecha}#"

        Try
            File.AppendAllText(filePath, destinoCompleto)
        Catch ex As Exception
            MessageBox.Show("Error: " + ex.Message)
        End Try
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Me.Hide()
        Viajes.Show()
    End Sub


End Class