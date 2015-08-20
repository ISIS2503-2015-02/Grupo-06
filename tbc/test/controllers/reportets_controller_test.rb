require 'test_helper'

class ReportetsControllerTest < ActionController::TestCase
  setup do
    @reportet = reportets(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:reportets)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create reportet" do
    assert_difference('Reportet.count') do
      post :create, reportet: { fecha: @reportet.fecha, tiempopromedio: @reportet.tiempopromedio, trayectos: @reportet.trayectos }
    end

    assert_redirected_to reportet_path(assigns(:reportet))
  end

  test "should show reportet" do
    get :show, id: @reportet
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @reportet
    assert_response :success
  end

  test "should update reportet" do
    patch :update, id: @reportet, reportet: { fecha: @reportet.fecha, tiempopromedio: @reportet.tiempopromedio, trayectos: @reportet.trayectos }
    assert_redirected_to reportet_path(assigns(:reportet))
  end

  test "should destroy reportet" do
    assert_difference('Reportet.count', -1) do
      delete :destroy, id: @reportet
    end

    assert_redirected_to reportets_path
  end
end
