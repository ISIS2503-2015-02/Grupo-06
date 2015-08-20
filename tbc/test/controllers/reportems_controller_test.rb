require 'test_helper'

class ReportemsControllerTest < ActionController::TestCase
  setup do
    @reportem = reportems(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:reportems)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create reportem" do
    assert_difference('Reportem.count') do
      post :create, reportem: { fecha: @reportem.fecha, trayectos: @reportem.trayectos }
    end

    assert_redirected_to reportem_path(assigns(:reportem))
  end

  test "should show reportem" do
    get :show, id: @reportem
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @reportem
    assert_response :success
  end

  test "should update reportem" do
    patch :update, id: @reportem, reportem: { fecha: @reportem.fecha, trayectos: @reportem.trayectos }
    assert_redirected_to reportem_path(assigns(:reportem))
  end

  test "should destroy reportem" do
    assert_difference('Reportem.count', -1) do
      delete :destroy, id: @reportem
    end

    assert_redirected_to reportems_path
  end
end
