Public Class Barco
    Public Property CodCapitan As Integer
    Public Property Eslora As Integer
    Public Property Tripulantes As Integer
    Public Property Construido As Date
    Public Property Bandera As String

    Public Sub New()
        Me.CodCapitan = ""
        Me.Eslora = 0.0
        Me.Tripulantes = 0
        Me.Construido = Date.MinValue
        Me.Bandera = ""
    End Sub

    Public Sub New(capitan As String, eslora As Integer, tripulantes As Integer, construido As Date, bandera As String)
        Me.CodCapitan = capitan
        Me.Eslora = eslora
        Me.Tripulantes = tripulantes
        Me.Construido = construido
        Me.Bandera = bandera
    End Sub

    Public Overrides Function ToString() As String
        Return $"Capitán: {CodCapitan}, Eslora: {Eslora} m, Tripulantes: {Tripulantes}, Construido: {Construido:dd/MM/yyyy}, Bandera: {Bandera}"
    End Function
End Class
