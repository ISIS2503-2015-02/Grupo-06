json.array!(@reservas) do |reserva|
  json.extract! reserva, :id, :fecha, :direccionOrigen, :direccionLlegada, :estado, :horaSalida, :horaLlegada, :ruta, :distancia
  json.url reserva_url(reserva, format: :json)
end
