require 'test_helper'

class TranviaControllerTest < ActionController::TestCase
  setup do
    @tranvium = tranvia(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:tranvia)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create tranvium" do
    assert_difference('Tranvium.count') do
      post :create, tranvium: { boton_panico: @tranvium.boton_panico, estado: @tranvium.estado, identificacion: @tranvium.identificacion, kilms_ultima_revision: @tranvium.kilms_ultima_revision, linea: @tranvium.linea, posicion: @tranvium.posicion, temperatura: @tranvium.temperatura }
    end

    assert_redirected_to tranvium_path(assigns(:tranvium))
  end

  test "should show tranvium" do
    get :show, id: @tranvium
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @tranvium
    assert_response :success
  end

  test "should update tranvium" do
    patch :update, id: @tranvium, tranvium: { boton_panico: @tranvium.boton_panico, estado: @tranvium.estado, identificacion: @tranvium.identificacion, kilms_ultima_revision: @tranvium.kilms_ultima_revision, linea: @tranvium.linea, posicion: @tranvium.posicion, temperatura: @tranvium.temperatura }
    assert_redirected_to tranvium_path(assigns(:tranvium))
  end

  test "should destroy tranvium" do
    assert_difference('Tranvium.count', -1) do
      delete :destroy, id: @tranvium
    end

    assert_redirected_to tranvia_path
  end
end
