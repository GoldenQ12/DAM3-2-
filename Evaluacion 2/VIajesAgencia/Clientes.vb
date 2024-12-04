Imports System.IO

Public Class Clientes
    Dim filePath As String = "clientes.txt"
    Private Sub Clientes_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Me.CenterToScreen()
        Dim deleteColumn As New DataGridViewButtonColumn With {
            .Name = "Delete",
            .HeaderText = "Delete",
            .Text = "ELIMINAR",
            .UseColumnTextForButtonValue = True,
            .Width = 250
        }
        deleteColumn.DefaultCellStyle.BackColor = Color.FromArgb(153, 180, 209)
        deleteColumn.DefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleCenter
        DataGridView1.Columns.Add(deleteColumn)
        DataGridView1.RowTemplate.Height = 30
        LoadData()
    End Sub

    Public Sub LoadData()
        Dim dt As New DataTable()

        dt.Columns.Add("Nombre")
        dt.Columns.Add("Apellido")
        dt.Columns.Add("Teléfono")
        dt.Columns.Add("Euros reserva")

        Try
            Dim lines As String() = File.ReadAllLines(filePath)

            For Each line As String In lines
                Dim clienteData As String() = line.Split("#")

                For Each cliente As String In clienteData
                    If Not String.IsNullOrWhiteSpace(cliente) Then
                        Dim fields As String() = cliente.Split("€")
                        dt.Rows.Add(fields(0), fields(1), fields(2), fields(3) + " €")
                    End If
                Next
            Next

            DataGridView1.DataSource = dt

        Catch ex As Exception
            MessageBox.Show("Error reading file: " & ex.Message)
        End Try
    End Sub

    Private Sub BtnAddCliente_Click(sender As Object, e As EventArgs) Handles btnAdd.Click
        If ComprobarValidaciones() Then
            AddCliente()
            MessageBox.Show("Cliente agregado correctamente")
            txtApellido.Text = ""
            txtNombre.Text = ""
            txtNumero.Text = ""
            txtPrecio.Text = ""
            LoadData()
        End If
    End Sub

    Public Function ComprobarValidaciones() As Boolean
        If txtNumero.Text = "" Or txtApellido.Text = "" Or txtNombre.Text = "" Or txtPrecio.Text = "" Then
            MessageBox.Show("Por favor, rellene todos los campos")
            Return False
        End If
        If Not System.Text.RegularExpressions.Regex.IsMatch(txtNombre.Text, "^[a-zA-Z\s]+$") Or Not System.Text.RegularExpressions.Regex.IsMatch(txtApellido.Text, "^[a-zA-Z\s]+$") Then
            MessageBox.Show("El nombre y apellido solo puede contener letras y espacios")
            Return False
        End If
        If Not System.Text.RegularExpressions.Regex.IsMatch(txtNumero.Text, "^\d{9}$") Then
            MessageBox.Show("El numero de teléfono tiene que tener una longitud de solo 9 digitos")
            Return False
        End If
        If Not System.Text.RegularExpressions.Regex.IsMatch(txtPrecio.Text, "^\d+$") Then
            MessageBox.Show("El precio solo puede contener numeros de 0 a 9")
            Return False
        End If

        Try
            If Not File.Exists(filePath) Then
                MessageBox.Show("El fichero no existe.")
                Return False
            End If

            Dim lineas As List(Of String) = File.ReadAllLines(filePath).ToList()
            For Each linea As String In lineas
                If linea.StartsWith(txtNombre.Text) Then
                    MessageBox.Show("El nombre solicitado ya existe")
                    Return False
                End If
            Next
        Catch ex As Exception
            MessageBox.Show(ex.Message)
        End Try
        Return True
    End Function

    Public Sub AddCliente()
        Try
            Dim nombre As String = txtNombre.Text
            Dim ape As String = txtApellido.Text
            Dim precio As String = txtPrecio.Text
            Dim numero As String = txtNumero.Text

            Dim cliente As String = $"{nombre}€{ape}€{numero}€{precio}#" & Environment.NewLine()

            File.AppendAllText(filePath, cliente)
        Catch ex As Exception
            MessageBox.Show("Error: " + ex.Message)
        End Try
    End Sub




    Private Sub DataGridViewDestinos_CellContentClick(sender As Object, e As DataGridViewCellEventArgs) Handles DataGridView1.CellContentClick
        If e.ColumnIndex = DataGridView1.Columns("Delete").Index Then
            Dim result As DialogResult = MessageBox.Show("Estas seguro que quieres eliminar este cliente?", "Confirmation", MessageBoxButtons.YesNo)
            If result = DialogResult.Yes Then
                Dim cliente As String = DataGridView1.Rows(e.RowIndex).Cells("Nombre").Value.ToString()
                If EliminarCliente(cliente) Then
                    MessageBox.Show("Cliente eliminado correctamente")
                End If
                LoadData()
            End If
        End If
        If e.ColumnIndex = DataGridView1.Columns("Nombre").Index Then

        End If
    End Sub
    Public Function EliminarCliente(cliente As String) As Boolean
        If Not File.Exists(filePath) Then
            MessageBox.Show("El fichero no existe.")
            Return False
        End If

        Dim lineas As List(Of String) = File.ReadAllLines(filePath).ToList()
        Using writer As New StreamWriter(filePath, False)
            For Each linea As String In lineas
                If Not linea.StartsWith(cliente) Then
                    writer.WriteLine(linea)
                End If
            Next
        End Using
        Return True
    End Function

    Private Sub btnBack_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        Me.Close()
        Viajes.Show()
    End Sub
End Class
