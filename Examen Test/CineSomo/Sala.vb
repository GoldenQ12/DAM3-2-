Public Class Sala
    Private Property _sala As Integer
    Private Property _entradas As Integer

    Public Property Sala() As Integer
        Get
            Return _sala
        End Get
        Set(value As Integer)
            _sala = value
        End Set
    End Property

    Public Property Entradas() As Integer
        Get
            Return _entradas
        End Get
        Set(value As Integer)
            _entradas = value
        End Set
    End Property

    Public Sub New(ByVal entradas As Integer)
        _sala = 5
        _entradas = entradas
    End Sub

    Public Sub New()
        _sala = 0
        _entradas = 0
    End Sub

    Public Overrides Function ToString() As String
        Return "Sala: " & Sala & Environment.NewLine & "Entradas: " & Entradas
    End Function

End Class
