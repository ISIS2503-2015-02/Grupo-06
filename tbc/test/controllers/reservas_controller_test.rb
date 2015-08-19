require 'test_helper'

class ReservasControllerTest < ActionController::TestCase
  setup do
    @reserva = reservas(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:reservas)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create reserva" do
    assert_difference('Reserva.count') do
      post :create, reserva: { direccionLlegada: @reserva.direccionLlegada, direccionOrigen: @reserva.direccionOrigen, distancia: @reserva.distancia, estado: @reserva.estado, fecha: @reserva.fecha, horaLlegada: @reserva.horaLlegada, horaSalida: @reserva.horaSalida, ruta: @reserva.ruta }
    end

    assert_redirected_to reserva_path(assigns(:reserva))
  end

  test "should show reserva" do
    get :show, id: @reserva
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @reserva
    assert_response :success
  end

  test "should update reserva" do
    patch :update, id: @reserva, reserva: { direccionLlegada: @reserva.direccionLlegada, direccionOrigen: @reserva.direccionOrigen, distancia: @reserva.distancia, estado: @reserva.estado, fecha: @reserva.fecha, horaLlegada: @reserva.horaLlegada, horaSalida: @reserva.horaSalida, ruta: @reserva.ruta }
    assert_redirected_to reserva_path(assigns(:reserva))
  end

  test "should destroy reserva" do
    assert_difference('Reserva.count', -1) do
      delete :destroy, id: @reserva
    end

    assert_redirected_to reservas_path
  end
end
