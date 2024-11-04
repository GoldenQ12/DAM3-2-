Public Class Ticket
    Private Property _cantidadEntradas As Integer
    Private Property _sala As Sala
    Private Property _sesion As String

    Public Property CantidadEntradas() As Integer
        Get
            Return _cantidadEntradas
        End Get
        Set(value As Integer)
            _cantidadEntradas = value
        End Set
    End Property

    Public Property Sala() As Sala
        Get
            Return _sala
        End Get
        Set(value As Sala)
            _sala = Sala
        End Set
    End Property

    Public Property Sesion As String
        Get
            Return _sesion
        End Get
        Set(value As String)
            _sesion = value
        End Set
    End Property

    Public Overrides Function ToString() As String
        Return "Entradas: " & CantidadEntradas & Environment.NewLine & "Sala: " & Sala.Sala & Environment.NewLine & "Sesion: " & Sesion
    End Function

    Public Sub New(ByVal cantidad As Integer, ByVal sala As Sala, ByVal sesion As String)
        _cantidadEntradas = cantidad
        _sala = sala
        _sesion = sesion
    End Sub
End Class